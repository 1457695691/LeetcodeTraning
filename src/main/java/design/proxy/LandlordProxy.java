package design.proxy;

/**
 * @author Ayuan
 * @Description: 中介
 * @date 2023/4/26 17:59
 */
public class LandlordProxy {

    public Landlord landlord;

    public LandlordProxy(Landlord landlord) {
        this.landlord = landlord;
    }

    public void apartmentToRent() {
        apartmentToRentBefore();
        landlord.apartmentToRent();
        apartmentToRentAfter();
    }

    public void apartmentToRentBefore() {
        System.out.println("出租房前,收取中介费");
    }

    public void apartmentToRentAfter() {
        System.out.println("出租房后,签订合同");
    }

}
