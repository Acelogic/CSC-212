package people;

public class PersonDemo1 {
    public static void main(String[] args) {
        Person bd = new Person("Bob Dylan",5,24,1941);
        Person nr = new Person("Noomi Rapace",12,28,1974);
        Person pw = new Person("Pharrell Williams",4,5,1973);
        Person fs = new Person("Frank Sinatra", 12,12 ,1915);
        Person dk = new Person("Diana Krall", 11,16,1964);
        Person mc = new Person("Miguel Cruz", 4,6,2000);

        //Displaying 6 Objects in the STDOUT Stream
        System.out.println(bd + " " +bd.initials() + " " + "isBabyBooomer: "+bd.isBoomer());
        System.out.println(nr + " " +nr.initials() + " " + "isBabyBooomer: "+nr.isBoomer());
        System.out.println(pw + " " +pw.initials() + " " + "isBabyBooomer: "+pw.isBoomer());
        System.out.println(fs + " " +fs.initials() + " " + "isBabyBooomer: "+pw.isBoomer());
        System.out.println(dk + " " +dk.initials() + " " + "isBabyBooomer: "+dk.isBoomer());
        System.out.println(mc + " " +mc.initials() + " " + "isBabyBooomer: "+mc.isBoomer());
    }
}
