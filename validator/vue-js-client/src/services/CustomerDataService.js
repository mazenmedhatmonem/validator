import http from "../ http-common";

class CustomerDataService {
    getAllCustomers() {
        return http.get("/customers");
    }
    getAllCountries() {
        return http.get("/countries");
    }
}

export default new CustomerDataService();
