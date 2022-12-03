public class Mathf {
    public static float Clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }
    public static int Clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }
    
    
}
