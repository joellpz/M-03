package Carrito;

public class Electronics extends Product {
    float warrantyDays;

    public void setWarrantyDays(int warrantyDays) {
        this.warrantyDays = warrantyDays;
    }

    public Electronics() {
    }

    /*public Electronics(int initPrice, int barCode, String name, int warrantyDays) {
        this.warrantyDays = warrantyDays;
        this.price = priceCalc(initPrice);
        this.barCode = barCode;
        this.name = name;
    }*/

    /*
    * priceCalc: Calcula el preu amb el preu base variant segons la formula determinada
    * dins d'aquesta funció.
    * */
    private float priceCalc(float initPrice) {
        return (initPrice + initPrice * (warrantyDays / 365) * 0.1f);
    }


    @Override
    public void setPrice(float price) {
        this.price = priceCalc(price);
    }
}
