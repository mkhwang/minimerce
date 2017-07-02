package com.minimerce.core.component.stock;

import com.minimerce.builder.StockBuilder;
import com.minimerce.core.domain.deal.option.usable.UsableOptionDslRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 14/06/2017.
 */
public class UsableStockReducerTest {
    private UsableStockReducer reducer;
    private final UsableOptionDslRepository mockUsableOptionDslRepository = mock(UsableOptionDslRepository.class);

    @Before
    public void setup() {
        reducer = new UsableStockReducer(mockUsableOptionDslRepository);
    }

    @Test
    public void testShouldBeReduce() {
        Stock stock = StockBuilder.aStock().build();
        reducer.reduce(stock);
        verify(mockUsableOptionDslRepository).decrease(stock);
    }
}