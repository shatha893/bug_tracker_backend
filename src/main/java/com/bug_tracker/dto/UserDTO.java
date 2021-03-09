package com.bug_tracker.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

        private String firstName;


        private String lastName;

        @NotNull(message = "Email shouldn't be NULL!")
        @Email(message = "Wrong email representation!")
        private String email;

        @NotNull(message = "Password shouldn't be NULL!")
        @Size(min = 6,max = 100,message = "Password should be at least 6 characters!")
        private String password;

        private String profilePicture;


        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getProfilePicture() {
            return profilePicture;
        }

        public void setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
        }
}
