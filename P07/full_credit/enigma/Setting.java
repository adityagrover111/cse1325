package enigma;

import java.util.Objects;
import java.util.Arrays;

import java.util.Map;
import java.util.HashMap;

public class Setting implements Comparable<Setting> {    
    public Setting(String[] rotors, int[] rotorPositions, int[] ringSettings) {
        if(rotors == null) rotors = new String[]{"I", "II", "III"};
        else if(rotors.length != 3) 
            throw new IllegalArgumentException("" + rotors.length + " rotors");
        else this.rotors = rotors;
        
        if(rotorPositions == null) rotorPositions = new int[] {0,0,0};
        else if (rotorPositions.length != 3) 
            throw new IllegalArgumentException("" + rotorPositions.length + " rotorPositions");
        else this.rotorPositions = rotorPositions;
        
        if(ringSettings == null) ringSettings = new int[] {0,0,0};
        else if (ringSettings.length != 3) 
            throw new IllegalArgumentException("" + ringSettings.length + " ringSettings");
        else this.ringSettings = ringSettings;
        
        // Used by compareTo for comparing Rotors, which should be enums!
        if(rValues == null) {
            rValues = new HashMap<>();
            rValues.put("I", 1);
            rValues.put("II", 2);
            rValues.put("III", 3);
            rValues.put("IV", 4);
            rValues.put("V", 5);
            rValues.put("VI", 6);
            rValues.put("VII", 7);
            rValues.put("VIII", 8);
        }
    }

    public Setting() {
        this(null, null, null);
    }
    
    public String[] getRotors() {
        return rotors;
    }
    
    public int[] getRotorPositions() {
        return rotorPositions;
    }
    
    public int[] getRingSettings() {
        return ringSettings;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Setting that = (Setting) o;
        return Arrays.equals(this.rotors, that.rotors)
            && Arrays.equals(this.rotorPositions, that.rotorPositions)
            && Arrays.equals(this.ringSettings, that.ringSettings);
    }
    @Override
    public int hashCode() {
        return Objects.hash(rotors, rotorPositions, ringSettings);
    }
    
    @Override
    public int compareTo(Setting that) {
        // Try the rotors first (rvalues is loaded in the constructor)
        for(int i=0; i<3; ++i) {
            Integer r1 = rValues.get(this.rotors[i]);
            Integer r2 = rValues.get(that.rotors[i]);
            if(r1.compareTo(r2) != 0) return r1.compareTo(r2);
        }
        for(int i=0; i<3; ++i) {
            Integer r1 = this.rotorPositions[i];
            Integer r2 = that.rotorPositions[i];
            if(r1.compareTo(r2) != 0) return r1.compareTo(r2);
        }
        for(int i=0; i<3; ++i) {
            Integer r1 = this.ringSettings[i];
            Integer r2 = that.ringSettings[i];
            if(r1.compareTo(r2) != 0) return r1.compareTo(r2);
        }
        return 0;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Enigma settings:");
        for(var s : rotors) sb.append(" " + s);
        sb.append("  ");
        for(var i : rotorPositions) sb.append(" " + i);
        sb.append("  ");
        for(var i : ringSettings) sb.append(" " + i);
        
        return sb.toString();
    }
    private String[] rotors;
    private int[] rotorPositions;
    private int[] ringSettings;
    private static Map<String, Integer> rValues = null;
}
