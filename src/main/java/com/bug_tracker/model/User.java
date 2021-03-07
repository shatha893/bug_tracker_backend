package com.bug_tracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private String profilePicture;
        private String password;
        private Date updateDate;
        private Integer updatedBy;
        private Date creationDate;
        private Integer createdBy;


        public User(){ }

        public User(String firstName, String lastName, String email, String password, String profilePicture, Date updateDate, Integer updatedBy, Date creationDate, Integer createdBy) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.profilePicture = profilePicture;
            this.updateDate = updateDate;
            this.updatedBy = updatedBy;
            this.creationDate = creationDate;
            this.createdBy = createdBy;
        }

        public String getProfilePicture() {
            return profilePicture;
        }

        public void setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
        }

        public Date getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Date updateDate) {
            this.updateDate = updateDate;
        }

        public Integer getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(Integer updatedBy) {
            this.updatedBy = updatedBy;
        }

        public Date getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Date creationDate) {
            this.creationDate = creationDate;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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
}



