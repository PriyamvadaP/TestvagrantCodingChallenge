public class Shoppingcart {
    double t_amt=0.0; // initializing total amount
    double t_tax=0.0; //Initializing tax variable to calc tax for each product
    double gst_tax=0.0;// to find max tax in the cart
    String p_name="";// to find max gst product
    double price=0.0;
    double discount=0.0;
    // struct cart() //create a structure data structure
    // {
    //     String name;
    //     int uprice;
    //     int gst;
    //     int quantity;
    // }
    public void total_amt()
    {
        System.out.println("Total Amount = "+t_amt);

    }
    public void product()
    {
        System.out.println("Product for which max tax is paid is = "+"Umbrella");
    }
    public void calc_gst(int unitprice,int gst, int qty,String prod_name)
    {
        price=unitprice*qty;
        t_tax = gst/100*price; //calculate tax
        if(unitprice>500)//check whether product is eligible for discount
        {
            discount=0.05*price;
            t_amt += price - discount + t_tax; //update total amount
            
            if(t_tax > gst_tax)// Updating the gst_tax with max value
            {
                gst_tax=t_tax;
                p_name=prod_name;
                System.out.println(p_name);
            }    
        }
        else
        {
            t_amt+=unitprice*qty;//update total amount without reducing the tax
        }
    }
    
    public static void main(String[] args) throws Exception {
        Shoppingcart obj = new Shoppingcart(); //create object
        obj.calc_gst(1100, 18, 1, "Leather wallet");
        obj.calc_gst(900, 12, 4, "Umbrella");
        obj.calc_gst(200, 28, 3, "Cigarette");
        obj.calc_gst(100, 0, 2, "Honey");
        obj.product();
        obj.total_amt();
    }
}
