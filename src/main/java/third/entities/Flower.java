package third.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Flower {
    private int id;
    private boolean bloom;
    private String name;
    private String type;
    private String kind;
    private String subtype;
    private double price;

    public Flower() {

    }

    public Flower(int id, boolean bloom, String name, String type, String kind, String subtype, double price) {
        this.id = id;
        this.bloom = bloom;
        this.name = name;
        this.type = type;
        this.kind = kind;
        this.subtype = subtype;
        this.price = price;
    }

    public boolean isBloom() {
        return bloom;
    }

    public void setBloom(boolean bloom) {
        this.bloom = bloom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Flower rhs = (Flower) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.bloom, rhs.bloom)
                .append(this.name, rhs.name)
                .append(this.type, rhs.type)
                .append(this.kind, rhs.kind)
                .append(this.subtype, rhs.subtype)
                .append(this.price, rhs.price)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(bloom)
                .append(name)
                .append(type)
                .append(kind)
                .append(subtype)
                .append(price)
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
                .append("id", id)
                .append("bloom", bloom)
                .append("name", name)
                .append("type", type)
                .append("kind", kind)
                .append("subtype", subtype)
                .append("price", price)
                .toString();
    }
}
