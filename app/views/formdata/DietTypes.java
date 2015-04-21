package views.formdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class to manipulate telephone types.
 */
public class DietTypes {
  private static String[] dietTypes = {"Chicken", "Fish", "Beef", "Dairy", "Gluten"};

  /**
   * Builds a map of telephone types set to false.
   *
   * @return A map of telephone types
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type : dietTypes) {
      typeMap.put(type, false);
    }
    return typeMap;
  }

  /**
   * Return the Diet instance in the database with name 'dietType' or null if not found.
   * @param dietName The diet name.
   * @return The Hobby instance, or null.
   */
  public static String findDietTypes(String dietName) {
    for (String dietType : dietTypes) {
      if (dietType.equals(dietName)) {
        return dietName;
      }
    }
    return null;
  }

  /**
   * Checks if the type passed is a legal telephone type.
   *
   * @param type The telephone type.
   * @return True if the type is legal, or else return false.
   */
  public static boolean isType(String type) {
    for (String legalType : dietTypes) {
      if (type.equals(legalType)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Builds a map of diet types, where the types are strings representing booleans.
   *
   * @param types The type to be set to true.
   * @return A map of diet types.
   */
  public static Map<String, Boolean> getTypes(List<String> types) {
    Map<String, Boolean> typeMap = getTypes();
    for(String type : types){
      if (isType(type)) {
        typeMap.put(type, true);
      }
    }
    return typeMap;
  }
}