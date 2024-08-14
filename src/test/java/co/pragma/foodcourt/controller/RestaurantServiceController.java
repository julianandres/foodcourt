package co.pragma.foodcourt.controller;


import co.pragma.foodcourt.model.Restaurant;
import co.pragma.foodcourt.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    void getAllRestaurantsTest() throws Exception {
        mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk());
    }

    @Test
    void saveRestaurantTest() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");

        when(restaurantService.saveRestaurant(any(Restaurant.class))).thenReturn(restaurant);

        mockMvc.perform(post("/api/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test Restaurant\", \"address\": \"123 Street\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Restaurant"));
    }
}