<template>
  <v-app id="customers-app">
        <v-data-table
            id="customers-table"
            :items="filteredCustomers"
            :items-per-page="15"
            class="data-table"
            :headers="headers"
            disable-sort>

          <template v-slot:header.valid>
            <v-select
                v-model="selectedStatus"
                :items="validity"
                clearable
                label="State"
            ></v-select>
          </template>

            <template v-slot:header.countryName>
              <v-select
                  v-model="selectedCountry"
                  :items="countries"
                  clearable
                  label="Country"
              ></v-select>
            </template>

          <template v-slot:body="{ items }">
            <tr v-for="customer in items" :key="customer.id">
              <td>{{ customer.name }}</td>
              <td>{{ customer.countryName }}</td>
              <td>{{ customer.phoneNumber }}</td>
              <td>
                <p v-if="customer.valid">valid</p>
                <p v-else >invalid</p>
              </td>
            </tr>
          </template>
        </v-data-table>
  </v-app>
</template>
<script>
import CustomerDataService from "../services/CustomerDataService";
export default {
  name: "Customer",
  data() {
    return {
      registeredCustomers: [],
      responseSuccess: false,
      countries:  [],
      validity: ['valid' ,'invalid'],
      selectedCountry:null,
      selectedStatus: null,
      headers: [
      {
        text: 'Name',
        value: 'name',
      },
      {
        text: 'Country',
        value: 'countryName',
      },
      {
        text: 'Phone',
        value: 'phoneNumber',
      },
      {
        text: 'State',
        value: 'valid',
      }
    ]


  };
  },
  computed: {
    filteredCustomers() {
      return this.registeredCustomers.filter((cust) => {
        return (
            (!this.selectedCountry || this.selectedCountry == cust.countryName) && this.filterByStatus(cust)
        );
      });
    },
  },
  mounted() {
    this.findAllCustomers();
    this.findAllCountries();
  },
  methods: {
    findAllCustomers: async function () {
      const data = await CustomerDataService.getAllCustomers();
      this.registeredCustomers = data.data;
    },
    findAllCountries: async function () {
      const data = await CustomerDataService.getAllCountries();
      this.countries = data.data;
    },
    filterByStatus: function (cust) {
      return (
          !this.selectedStatus ||
          (this.selectedStatus == "valid" && cust.valid) ||
          (this.selectedStatus == "invalid" && !cust.valid)
      );
    }
  },
};
</script>

<style>
.data-table table {
  line-height: 3;
}
.data-table tr td {
  border-bottom: thin solid rgba(0, 0, 0, 0.12);
}
</style>
