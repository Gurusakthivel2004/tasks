package runner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Random;

public class ReflectorRunner {
    public static void main(String[] args) {
        try {
            Class<?> stringClass = Class.forName("tasks.StringTask");
            Constructor<?> constructor = stringClass.getConstructor();
            Object constructorObject = constructor.newInstance();
            ReflectorRunner runner = new ReflectorRunner();
            
            Method checkStartsWith = stringClass.getMethod("checkStartsWith", String.class, String.class);
            checkStartsWith.invoke(constructorObject, null, null);
            
            Method checkEndsWith = stringClass.getMethod("checkEndsWith", String.class, String.class);
            checkEndsWith.invoke(constructorObject, null, null);
            
            Method equalCaseSensitive = stringClass.getMethod("equalCaseSensitive", String.class, String.class);
            equalCaseSensitive.invoke(constructorObject, null, null);
            
            Method equalInCaseSensitive = stringClass.getMethod("equalInCaseSensitive", String.class, String.class);
            equalInCaseSensitive.invoke(constructorObject, null, null);
            
            Method noSpaceAtEnds = stringClass.getMethod("noSpaceAtEnds", String.class);
            noSpaceAtEnds.invoke(constructorObject, null);
            
            Method mergeString = stringClass.getMethod("mergeString", String.class, String[].class);
            mergeString.invoke(constructorObject, null, (String[]) null);
            
            Method greatPosition = stringClass.getMethod("greatPosition", String.class, char.class);
            greatPosition.invoke(constructorObject, null, runner.randomChar());
            
            Method concatenate = stringClass.getMethod("concatenate", String.class, String.class, String.class);
            concatenate.invoke(constructorObject, null, null, null);
            
            Method toEnclose = stringClass.getMethod("toEnclose", String.class, String.class, String.class);
            toEnclose.invoke(constructorObject, null, null, null);
            
            Method toReverse = stringClass.getMethod("toReverse", String.class);
            toReverse.invoke(constructorObject, null);
            
            Method toUpperCase = stringClass.getMethod("toUpperCase", String.class);
            toUpperCase.invoke(constructorObject, null);
            
            Method toLowerCase = stringClass.getMethod("toLowerCase", String.class);
            toLowerCase.invoke(constructorObject, null);
            
            Method firstNCharacters = stringClass.getMethod("firstNCharacters", String.class, int.class);
            firstNCharacters.invoke(constructorObject, null, runner.randomInteger());
            
            Method lastNCharacters = stringClass.getMethod("lastNCharacters", String.class, int.class);
            lastNCharacters.invoke(constructorObject, null, runner.randomInteger());
            
            Method stringLength = stringClass.getMethod("stringLength", String.class);
            stringLength.invoke(constructorObject, null);
            
            Method characterAt = stringClass.getMethod("characterAt", String.class, int.class);
            characterAt.invoke(constructorObject, null, runner.randomInteger());
            
            Method toCharArray = stringClass.getMethod("toCharArray", String.class);
            toCharArray.invoke(constructorObject, null);
            
            Method countCharacter = stringClass.getMethod("countCharacter", String.class, char.class);
            countCharacter.invoke(constructorObject, null, runner.randomChar());
            
            Method replaceCharacters = stringClass.getMethod("replaceCharacters", String.class, String.class, int.class);
            replaceCharacters.invoke(constructorObject, null, null, runner.randomInteger());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int randomInteger() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public char randomChar() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'a');
    }
}
