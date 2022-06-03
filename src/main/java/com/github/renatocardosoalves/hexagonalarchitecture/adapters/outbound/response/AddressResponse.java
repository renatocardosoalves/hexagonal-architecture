package com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressResponse {

    @JsonProperty("cep")
    private String zipCode;
    @JsonProperty("logradouro")
    private String publicPlace;
    @JsonProperty("uf")
    private String state;
    @JsonProperty("localidade")
    private String city;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
