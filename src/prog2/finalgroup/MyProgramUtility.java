/**
 * @author Jasmin, Ramon Emmiel
 * @author Domingo, Diamond Darrel
 * @author Rabang, Gebreyl Isaac
 * @author Baltazar, Rudyard Lans
 * @author Urbiztondo, Karl Jasper
 * @author Bumanglag, AU
 */
package prog2.finalgroup;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class MyProgramUtility {

    /**
     * This line of code creates a file object named "dataFile" that points to a file named "data.txt" located in the "res" directory
     */
    public final File dataFile = new File("JasminBaltazarBumanglagDomingoRabangUrbiztondo9301FinalGroupProject/res/data.txt");

    /**
     * This is a method that takes an ArrayList of Citizen objects, a String representing a last name, and an
     * integer representing an age as input parameters, and returns a Citizen object that matches the specified
     * last name and age criteria.
     * @param dataFile - File to be read
     * @return citizens
     */
    public ArrayList<Citizen> readData(File dataFile){
        ArrayList<Citizen> citizens = new ArrayList<>();

        String currentText = "";
        int currentLine = 0;

        try {
            Scanner filePointer = new Scanner(dataFile);

            while (filePointer.hasNextLine()){
                currentLine++;
                currentText = filePointer.nextLine();

                String[] citizenData =currentText.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                String fullName = citizenData[0] + " " + citizenData[1];
                String email = citizenData[2];
                String address = citizenData[3].substring(1, citizenData[3].length() - 1);
                int age = Integer.parseInt(citizenData[4]);
                boolean resident = (citizenData[5].equalsIgnoreCase("Resident")) ? true : false;
                int district = Integer.parseInt(citizenData[6]);
                char gender = (citizenData[7].equalsIgnoreCase("Male")) ? 'M' : 'F';

                Citizen newCitizen = new Citizen(fullName,email,address,age,resident,district,gender);
                citizens.add(newCitizen);
            }
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("The data file is not found.");
        }catch (Exception e){
            System.out.println("An exception occured while reading line " + currentLine);
        }

        return citizens;
    }//End of readData method

    /**
     * This is a method that takes an ArrayList
     * of Citizen objects as an input parameter and returns
     * an integer value representing the count of male citizens in the list.
     * @param citizens - ArrayList to be counted
     * @return count
     */
    public int countMale(ArrayList<Citizen> citizens){
        int count = (int) citizens.stream()
                .filter(citizen -> citizen.getGender() == 'M')
                .count();

        return count;
    }//End of countMale method

    /**
     * This is a method that takes an ArrayList
     * of Citizen objects as an input parameter and returns
     * an integer value representing the count of female citizens in the list.
     * @param citizens - ArrayList to be counted
     * @return count
     */
    public int countFemale(ArrayList<Citizen> citizens){
        int count = (int) citizens.stream()
                .filter(citizen -> citizen.getGender() == 'F')
                .count();

        return count;
    }//End of countFemale

    /**
     * This is a method that takes an ArrayList
     * of Citizen objects as an input parameter and returns
     * an integer value representing the count of citizens who are residents in the list.
     * @param citizens - ArrayList to be counted
     * @return count
     */
    public int countResidents(ArrayList<Citizen> citizens){
        int count = (int) citizens.stream()
                .filter(citizen -> citizen.getResident() == true)
                .count();

        return count;
    }//End of countResidents

    /**
     * This is a method that takes an ArrayList
     * of Citizen objects as an input parameter and returns
     * an integer value representing the count of citizens who are not residents in the list.
     * @param citizens - ArrayList to be counted
     * @return count
     */
    public int countNonResidents(ArrayList<Citizen> citizens){
        int count = (int) citizens.stream()
                .filter(citizen -> citizen.getResident() == false)
                .count();

        return count;
    }//End of countNonResidents

    /**
     * This is a method that takes an ArrayList of Citizen objects and an integer
     * value representing an age as input parameters, and returns an integer value
     * representing the count of citizens in the list whose age matches the specified age.
     * @param citizens - ArrayList to be counted
     * @param age - criteria for counting
     * @return count
     */
    public int countCitizensByAge(ArrayList<Citizen> citizens, int age){
        int count = (int) citizens.stream()
                .filter(citizen -> citizen.getAge() == age)
                .count();

        return count;
    }//End of countCitizensByAge

    /**
     * This is a method that takes an ArrayList of Citizen objects as an input parameter
     * and returns an ArrayList containing the oldest citizens in the list.
     * @param citizens - ArrayList to get the oldest citizens from
     * @return ArrayList<>() or ArrayList<>(oldestCitizens)
     */
    public ArrayList<Citizen> getOldestCitizens(ArrayList<Citizen> citizens){
        OptionalInt maxAge = citizens.stream()
                .mapToInt(Citizen::getAge)
                .max();

        if (maxAge.isPresent()){
            List<Citizen> oldestCitizens = citizens.stream()
                    .filter(citizen -> citizen.getAge() == maxAge.getAsInt())
                    .collect(Collectors.toList());

            return new ArrayList<>(oldestCitizens);
        }else {
            return new ArrayList<>();
        }
    }//End of getOldestCitizens method

    /**
     * This is a method that takes an ArrayList of Citizen objects as an input parameter
     * and returns an ArrayList containing the youngest citizens in the list.
     * @param citizens - ArrayList to get youngest citizens from
     * @return ArrayList<>() or ArrayList<>(youngestCitizens)
     */
    public ArrayList<Citizen> getYoungestCitizens(ArrayList<Citizen> citizens) {
        OptionalInt minAge = citizens.stream()
                .mapToInt(Citizen::getAge)
                .min();

        if (minAge.isPresent()) {
            List<Citizen> youngestCitizens = citizens.stream()
                    .filter(c -> c.getAge() == minAge.getAsInt())
                    .collect(Collectors.toList());

            return new ArrayList<>(youngestCitizens);
        } else {
            return new ArrayList<>();
        }
    }//End of getYoungestCitizens method

    /**
     * This is a method that takes an ArrayList of Citizen objects and two integer values
     * representing lower and upper age limits as input parameters, and returns an ArrayList
     * containing all citizens whose age falls within the specified range.
     * @param citizens - ArrayList to get range from
     * @param lowerLimit - lower limit of range
     * @param upperLimit - upper limit of range
     * @return citizensInRange
     */
    public ArrayList<Citizen> citizensPerAgeRange(ArrayList<Citizen> citizens, int lowerLimit, int upperLimit){
        ArrayList<Citizen> citizensInRange = new ArrayList<>();

        citizens.stream()
                .filter(citizen -> citizen.getAge() >= lowerLimit && citizen.getAge() <= upperLimit)
                .forEach(citizensInRange :: add);

        return citizensInRange;
    }//End of citizensPerAgeRange method

    /**
     * This is a method that takes an ArrayList of Citizen objects, a district number, a boolean value
     * indicating whether the citizens must be residents, and a character representing the
     * gender as input parameters, and returns an ArrayList containing all citizens who meet the specified criteria.
     * @param citizens - ArrayList for filtering
     * @param district - criteria for filter
     * @param resident - criteria for filter
     * @param gender - criteria for filter
     * @return filteredCitizens
     */
    public ArrayList<Citizen> getCitizensPerFilter(ArrayList<Citizen> citizens, int district, boolean resident, char gender){
        ArrayList<Citizen> filteredCitizens = citizens.stream()
                .filter(citizen -> citizen.getDistrict() == district && citizen.getResident() == resident && citizen.getGender() == gender)
                .collect(Collectors.toCollection(ArrayList::new));

        return filteredCitizens;
    }//End of getCitizensPerFilter method

    /**
     * This is a method that takes an ArrayList of Citizen objects, a String representing
     * a last name, and an integer representing an age as input parameters, and returns
     * a Citizen object that matches the specified last name and age criteria.
     * @param citizens - ArrayList to get Citizen objects
     * @param lastName - specific last name for criteria
     * @param age - specific age for criteria
     * @return matchedCitizen
     */
    public Citizen getCitizenBySurnameAndAge (ArrayList<Citizen> citizens, String lastName, int age){
        Citizen matchedCitizen = citizens.stream()
                .filter(citizen -> {
                    String[] nameParts = citizen.getFullName().split(" ");
                    String citizenSurname = nameParts[1];
                    int citizenAge = citizen.getAge();
                    return citizenSurname.equalsIgnoreCase(lastName) && citizenAge == age;
                })
                .findFirst()
                .orElse(null);

        return matchedCitizen;
    }//End of getCitizenBySurnameAndAge

    /**
     * This method, calculateMeanAge(), takes an ArrayList of Citizen objects as input,
     * and returns the mean age of all the citizens in the list as a double value.
     * @param citizens - ArrayList to get mean from
     * @return mean
     */
    public double calculateMeanAge(ArrayList<Citizen> citizens){
        double mean = citizens.stream()
                .mapToInt(Citizen::getAge)
                .average()
                .orElse(Double.NaN);
        return mean;
    }//End of calculateMeanAge

    /**
     * This method, calculateMedianAge(), takes an ArrayList of Citizen objects
     * as input, and returns the median age of all the citizens in the list as a double.
     * @param citizens ArrayList to get median from
     * @return ages.get(size / 2)
     */
    public double calculateMedianAge(ArrayList<Citizen> citizens){
        ArrayList<Integer> ages = citizens.stream()
                .map(Citizen::getAge)
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        int size = ages.size();
        if (size % 2 == 0) {
            return (ages.get(size / 2 - 1) + ages.get(size / 2)) / 2.0;
        } else {
            return ages.get(size / 2);
        }
    }//End of calculateMedianAge

    /**
     * The calculateModeAge() method takes an ArrayList of Citizen objects
     * as input, and returns the mode age of all the citizens in the list
     * as a double. The mode is the value that appears most frequently in the list.
     * @param citizens ArrayList to get mode from
     * @return modeAge
     */
    public double calculateModeAge(ArrayList<Citizen> citizens){
        Map<Double, Integer> frequencyMap = new HashMap<>();

        for (Citizen citizen : citizens) {
            double age = citizen.getAge();
            frequencyMap.put(age, frequencyMap.getOrDefault(age, 0) + 1);
        }

        double modeAge = frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        return modeAge;
    }//End of calculateModeAge
}//End of Class
