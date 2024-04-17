package com.codeki.travelagency.utils;

import com.codeki.travelagency.dollar.model.Dollar;
import com.codeki.travelagency.dollar.utils.DollarUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DollarUtilsTest {
    @Test
    void fetchDollarTest() {
        DollarUtils mockedDollarUtils= mock(DollarUtils.class);
        Dollar dummyDollar = new Dollar();

        dummyDollar.setMoneda("USD");
        dummyDollar.setCasa("tarjeta");
        dummyDollar.setNombre("Tarjeta");
        dummyDollar.setVenta(1000.00);
        dummyDollar.setCompra(1200.00);

        when(mockedDollarUtils.fetchDollar()).thenReturn(dummyDollar);

        Dollar dollar = mockedDollarUtils.fetchDollar();

        assertEquals(1100.00, dollar.getPromedio());
    }
}