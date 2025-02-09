import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Country implements Comparable<Country>{
        int g,s,b;
        public Country(int g, int s, int b){
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(Country o) {
            if(this.g!=o.g){
                return o.g-this.g;
            }else if(this.s!=o.s){
                return o.s-this.s;
            }
            return o.b-this.b;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        Country target = new Country(0,0,0);
        Country[] countries = new Country[n];
        for(int i = 0; i<n;i++){
            split = in.readLine().split(" ");
            countries[i] = new Country(Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]));
            if(Integer.parseInt(split[0])==k)target = countries[i];
        }
        Arrays.sort(countries);
        int ans = 1;
        for(int i = 0; i<n;i++){
            if(countries[i].compareTo(target)>=0){
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }
}