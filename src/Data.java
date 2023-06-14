import java.util.ArrayList;
import java.util.List;

public class Data {
    //private ArrayList<Products> products;
    //
    int attempt;
    String names;
    private Data() {
        //product add
        Product newProduct1 = new Product("PRD1", "Champ", "Burger",120.00, 5);
        productList.add(newProduct1);

        Product newProduct2 = new Product("PRD2", "Coffee", "Drinks",15.25, 5);
        productList.add(newProduct2);

        Product newProduct3 = new Product("PRD3", "Extra Cheese", "Addons",15.00, 10);
        productList.add(newProduct3);

        Product newProduct4 = new Product("PRD4", "Champ with Fries", "Burger",150.00, 6);
        productList.add(newProduct4);

        Product newProduct5 = new Product("PRD5", "Ketchup", "Addons",20.00, 2);
        productList.add(newProduct5);

        Product newProduct6 = new Product("PRD6", "Chicken Burger", "Burger",75.00, 0);
        productList.add(newProduct6);


        //employee
        users newUser = new users("USR1","Dominic Francisco","Admin","iamgreil","123", "Active" );
        userList.add(newUser);
        users newUser1 = new users("USR2","Pablo Escobar","Employee","pablo","123", "Active" );
        userList.add(newUser1);
        users newUser2 = new users("USR3","Pepito Manaloto","Employee","testaccount1","123456","Active" );
        userList.add(newUser2);

    }

    private static final Data INSTANCE = new Data();

    public static Data getInstance() {
        return INSTANCE;
    }
    private List<Product> productList = new ArrayList<>();
    private List<users> userList = new ArrayList<>();
    private List<cart>cartList = new ArrayList<>();
    private List<receipt> receiptList = new ArrayList<>();
    public  List<users> getUserList() {
        return this.userList;
    }
    public  List<Product> getProductList() {
        return this.productList;
    }
    public  List<cart> getCartList() {
        return this.cartList;
    }


    public void addProduct(Product product) {
        productList.add(product);
    }
    public void deleteProduct(String codedToDelete){
    try {
        for (Product o: productList){
            if (codedToDelete.equals(o.getId())){

                    productList.remove(o);

                return;
            }
        }
    } catch (Exception e){
        System.out.println(e);
    }
}
    public void editProduct(String codeToEdit, String name, String category, double price, int qty){
        try {
            for (Product o: productList){
                if (codeToEdit.equals(o.getId())){
                    o.editProduct(name,category,price,qty);
                    return;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public int getAns(double sum){
        return 5;
    }
    public void addUser(users user){
        userList.add(user);
    }
    public boolean isUsernameAdmin(String username){
        for (users acc: userList){
            if (acc.getUsername().equals(username) ){
                if(acc.getLevel().equals("Admin")){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isUserNotLocked(String username){
        for (users acc: userList){
            if (acc.getUsername().equals(username) ){
                if(acc.getStatus().equals("Active")){
                    return true;
                }
            }
        }
        return false;
    }
    public void userAttempt(String name){
        if(name.equals(names)){
            attempt+=1;
            if(attempt==3){
                try {
                    for (users o: userList){
                        if (name.equals(o.getUsername())){
                            o.editStatus("Locked");
                            return;
                        }
                    }
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }else{
            names = name;
            attempt=1;
        }
    }

    public void deleteUser(String codedToDelete){
        try {
            for (users o: userList){
                if (codedToDelete.equals(o.getId())){

                    userList.remove(o);

                    return;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void ediUser(String codeToEdit, String name, String level, String username, String password, String status){
        try {
            for (users o: userList){
                if (codeToEdit.equals(o.getId())){
                    o.editUsers(name,level,username,password,status);
                    return;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean isAccountAdminLevel(String typedUsername, String typedPassword){
        for (users acc: userList){
            if (acc.getUsername().equals(typedUsername) && acc.getPassword().equals(typedPassword)){
                if(acc.getLevel().equalsIgnoreCase("Admin")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAccountEmployeeLevel(String typedUsername, String typedPassword){
        for (users acc: userList){
            if (acc.getUsername().equals(typedUsername) && acc.getPassword().equals(typedPassword)){
                if(acc.getLevel().equalsIgnoreCase("Employee")){
                    return true;
                }
            }
        }
        return false;
    }

    public void addtoCart(cart carts){
    cartList.add(carts);
/*       cartList.forEach(cart -> {
           System.out.println(cart.getName());
           System.out.println(cart.getPrice());
           System.out.println(cart.getQty());
           System.out.println(cart.getTotal());
       });*/
    }
    public void editQty(String nametoEdit, int qty){

        try {
            for (Product o: productList){
                System.out.println("qty");
                if (nametoEdit.equalsIgnoreCase(o.getName())){
                    o.editQty(qty);
                    System.out.println(qty);
                    return;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void editVoidQty(String nametoEdit, int qty){
        try {
            for (Product o: productList){
                if (nametoEdit.equals(o.getName())){
                    o.editQty(0);
                    o.editQty(qty+o.getQty());
                    return;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public double getSubtotal(){
        double total = 0;
        for(cart o: cartList){
            total += o.getTotal();
        }
        return total;
    }
    public void clearCart(){
        cartList.clear();
    }


    public void deleteCart(String codedToDelete){
        try {
            for (cart o: cartList){
                if (codedToDelete.equals(o.getName())){
                    cartList.remove(o);
                    return;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
