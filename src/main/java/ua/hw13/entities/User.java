package ua.hw13.entities;

//some class User for example
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;

    public User(int id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {

    }

    ;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String street, String suite, String city, String zipcode) {
        this.address = new Address(street, suite, city, zipcode);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    private class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;

        public Address(String street, String suite, String city, String zipcode) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

    }

    @Override
    public String toString() {
        return "User{\n\t" +
                "id=" + id +
                ";\n\tname='" + name + '\'' +
                ";\n\tusername='" + username + '\'' +
                ";\n\temail='" + email + '\'' +
                ";\n\taddress=" + address +
                ";\n\tphone='" + phone + '\'' +
                ";\n\twebsite='" + website + '\'' +
                ";\n}";
    }
}

