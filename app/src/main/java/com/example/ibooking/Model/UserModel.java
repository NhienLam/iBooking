package com.example.ibooking.Model;


import java.util.ArrayList;

/**
 * User  that contain user id, name, email, password, and  phone
 */
public class UserModel
{
    private int id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userPhone;
    /**
     * Constructs a UserModel object with user id, name, email, password, and  phone
     * @param userName name of users
     * @param userEmail email of users
     * @param userPassword password of users
     * @param userPhone phone numbers of users
     */
    public UserModel(int id,String userName,String userEmail,String userPassword, String userPhone)
    { this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;

    }
    /**
     * Get id of user
     * @return id of user
     */
    public int getId() {
        return id;
    }

    /**
     * @param  id id of users
     *  Set id of users.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @param  userName name of users
     *  Set name for users.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *Get user name
     * @return name of users
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param  userEmail email of users
     *  Set email for users
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     *Get user email
     * @return email of users
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     *Get user password
     * @return password of users
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param  userPassword password of user.
     *  Set password for users
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     *Get user phone number
     * @return phone number of users
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param  userPhone phone of users.
     *  Set phone numbers for users
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * Reset a password
     *  Generating a random password with the length of 10
     * @return return new password of users.
     */
    public String resetPassword()
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder newPassword = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            newPassword.append(AlphaNumericString.charAt(index));
        }

        return this.userPassword=newPassword.toString();
    }

    /**
     * Returns a String representation of UserModel object
     * @return a String representation of UserModel object
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "UserModel{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}