
//creation design pattern
//structural design pattern
public class BuilderPattern {
    public int id;
    public String name;
    public String phone;
    public Address adr;

    // Inner Address class
    public static class Address {
        public String street;
        public String city;
        public String state;

        public Address(String street, String city, String state) {
            this.street = street;
            this.city = city;
            this.state = state;
        }
    }

    // Constructor accepting Build object
    public BuilderPattern(Build build) {
        this.id = build.id;
        this.name = build.name;
        this.phone = build.phone;
        this.adr = build.adr;
    }

    // Builder Class
    public static class Build {
        private int id;
        private String name;
        private String phone;
        private Address adr; // Address field added

        public Build(String name, String phone, int id) {
            this.name = name;
            this.phone = phone;
            this.id = id;
        }

        public Build setAddress(Address adr) { // Method to set Address
            this.adr = adr;
            return this;
        }

        public BuilderPattern build() { // Final method to create the object
            return new BuilderPattern(this);
        }
    }

    public static void main(String[] args) {
        Address address = new Address("MG Road", "Mumbai", "Maharashtra");
        
        BuilderPattern obj = new Build("Shubham", "1234567890", 1)
                                .setAddress(address) // Setting address
                                .build(); // Building the object

        System.out.println("Name: " + obj.name);
        System.out.println("Phone: " + obj.phone);
        System.out.println("Address: " + obj.adr.street + ", " + obj.adr.city + ", " + obj.adr.state);
    }
}