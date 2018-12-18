package com.hbo.advertiser.documents;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "ad")
public class Ad {

    @Id
    private Long idAd;
    private String title;
    private String description;
    private Date creationDate;
    private Date publishDate;
    private String adType;
    private String location;

    private User advertiser;
    private Product product;
    private Category adCategory;

    public Ad() {}

    public Long getIdAd() {
        return idAd;
    }

    public void setIdAd(Long idAd) {
        this.idAd = idAd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(User advertiser) {
        this.advertiser = advertiser;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getAdCategory() {
        return adCategory;
    }

    public void setAdCategory(Category adCategory) {
        this.adCategory = adCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(idAd, ad.idAd) &&
                Objects.equals(title, ad.title) &&
                Objects.equals(description, ad.description) &&
                Objects.equals(creationDate, ad.creationDate) &&
                Objects.equals(publishDate, ad.publishDate) &&
                Objects.equals(adType, ad.adType) &&
                Objects.equals(location, ad.location) &&
                Objects.equals(advertiser, ad.advertiser) &&
                Objects.equals(product, ad.product) &&
                Objects.equals(adCategory, ad.adCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAd, title, description, creationDate, publishDate, adType, location, advertiser, product, adCategory);
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "";
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonStr = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
