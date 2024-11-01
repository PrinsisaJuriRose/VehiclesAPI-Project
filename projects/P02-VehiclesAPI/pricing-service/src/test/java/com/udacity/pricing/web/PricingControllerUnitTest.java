package com.udacity.pricing.web;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PriceException;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.net.URISyntaxException;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricingService pricingService;

    @Test
    public void getPrice() throws Exception {
        mockMvc.perform(get(new URI("/services/price?vehicleId=1"))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

      //  Mockito.verify(pricingService, times(1)).getPrice(1L);

    }
}
