/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensat.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author apple
 */
@Entity
@Table(name = "car")
@XmlRootElement
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcar")
    private Integer idcar;
    @Size(max = 45)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "serial")
    private String serial;
    @Column(name = "rent_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentDate;
    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @Size(max = 255)
    @Column(name = "pic")
    private String pic;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private CarUser userId;

    public Car() {
    }

    public Car(Integer idcar) {
        this.idcar = idcar;
    }

    public Car(Integer idcar, String serial) {
        this.idcar = idcar;
        this.serial = serial;
    }

    public Integer getIdcar() {
        return idcar;
    }

    public void setIdcar(Integer idcar) {
        this.idcar = idcar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public CarUser getUserId() {
        return userId;
    }

    public void setUserId(CarUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcar != null ? idcar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.idcar == null && other.idcar != null) || (this.idcar != null && !this.idcar.equals(other.idcar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensat.entities.Car[ idcar=" + idcar + " ]";
    }
    
}
