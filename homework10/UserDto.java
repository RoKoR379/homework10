package homework10;

public class UserDto {
        private String name;
        private Integer age;

        public UserDto(String name, Integer age){
            this.name = name;
            this.age = age;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\nname: ").append(name);
            sb.append("\nage: ").append(age);
            return sb.toString();
        }
    }
