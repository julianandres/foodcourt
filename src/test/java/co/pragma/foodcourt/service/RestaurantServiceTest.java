package co.pragma.foodcourt.service;

import co.pragma.foodcourt.model.Restaurant;
import co.pragma.foodcourt.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    @Test
    void saveRestaurantTest() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");

        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);

        Restaurant result = restaurantService.saveRestaurant(restaurant);
        assertEquals("Test Restaurant", result.getName());
        verify(restaurantRepository, times(1)).save(any(Restaurant.class));
    }

    @Test
    void getRestaurantByIdTest() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1L);

        when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurant));

        Optional<Restaurant> result = restaurantService.getRestaurantById(1L);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }
}