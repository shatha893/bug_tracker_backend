package com.bug_tracker.dto;

import com.bug_tracker.emailValidation.UniqueEmail;
import com.bug_tracker.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

        private Integer id;
        private String firstName;
        private String lastName;

        @NotNull
        @Email
        @UniqueEmail
        private String email;

        @NotNull
        @Size(min = 6,max = 100)
        private String password;

        private String profilePicture;

        public UserDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO(User user){
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.email = user.getEmail();
            this.profilePicture = user.getProfilePicture();
            this.password = user.getPassword();
            this.id = user.getId();
//            this.updateDate = updateDate;
//            this.updatedBy = updatedBy;
//            this.creationDate = creationDate;
//            this.createdBy = createdBy;
        }
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
