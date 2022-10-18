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
    * priceCalc: Calcula el precio con el precio base dependiendo de la formula determinada
    * dentro de esta funcion.
    * */
    private float priceCalc(float initPrice) {
        return (initPrice + initPrice * (warrantyDays / 365) * 0.1f);
    }


    @Override
    public void setPrice(float price) {
        this.price = priceCalc(price);
    }
}
