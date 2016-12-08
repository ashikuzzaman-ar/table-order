package model;

import java.io.Serializable;
import java.util.Objects;

public class Food implements Serializable{

    private final String menuCode;
    private final String menuName;
    private final int menuPrice;

    public Food(String menuCode, String menuName, int menuPrice) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.menuCode);
        hash = 29 * hash + Objects.hashCode(this.menuName);
        hash = 29 * hash + this.menuPrice;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Food other = (Food) obj;
        if (this.menuPrice != other.menuPrice) {
            return false;
        }
        if (!Objects.equals(this.menuCode, other.menuCode)) {
            return false;
        }
        return Objects.equals(this.menuName, other.menuName);
    }
}
