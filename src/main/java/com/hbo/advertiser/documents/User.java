package com.hbo.advertiser.documents;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "user")
public class User {

    @Id
    private Long id;

    private String name;
    private String familyName;
    private Date bDay;
    private String adress;
    private Long phoneNumber;
    private String mail;
    private String login;
    private String password;
    private String avatar;

    private List<Ad> userAds;

    public User() {
    }

    public User(Long id, String name, String familyName, Date bDay, String adress, Long phoneNumber, String mail, String login, String password, String avatar, List<Ad> userAds) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.bDay = bDay;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.login = login;
        this.password = password;
        this.avatar = avatar;
        this.userAds = userAds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Ad> getUserAds() {
        return userAds;
    }

    public void setUserAds(List<Ad> userAds) {
        this.userAds = userAds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(familyName, user.familyName) &&
                Objects.equals(bDay, user.bDay) &&
                Objects.equals(adress, user.adress) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(mail, user.mail) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(avatar, user.avatar) &&
                Objects.equals(userAds, user.userAds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, familyName, bDay, adress, phoneNumber, mail, login, password, avatar, userAds);
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "";
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
