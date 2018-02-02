package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class OperarrayTest implements WithAssertions {

    private static final long[] a = new long[] { 18, 69, -90, -78, 65, 40 };

    @Test
    public void shouldSobProperly() throws Exception {
        assertThat(Operarray.operArray(Operarray::som, a, 0)).isEqualTo(new long[] { 18, 87, -3, -81, -16, 24 });
    }

    @Test
    public void shouldMinProperly() throws Exception {
        assertThat(Operarray.operArray(Operarray::mini, a, a[0])).isEqualTo(new long[] { 18, 18, -90, -90, -90, -90 });
    }

    @Test
    public void shouldMaxiProperly() throws Exception {
        assertThat(Operarray.operArray(Operarray::maxi, a, a[0])).isEqualTo(new long[] { 18, 69, 69, 69, 69, 69 });
    }

    @Test
    public void shouldGcdiProperly() throws Exception {
        assertThat(Operarray.operArray(Operarray::gcdi, a, a[0])).isEqualTo(new long[] { 18, 3, 3, 3, 1, 1 });
    }

    @Test
    public void shouldLcmiProperly() throws Exception {
        assertThat(Operarray.operArray(Operarray::lcmi, a, a[0])).isEqualTo(new long[] { 18, 414, 2070, 26910, 26910, 107640 });
    }

    @Test
    public void test1_1() throws Exception {
        // given
        long[] a = new long[] { 10, 70, -97, -84, -96, -16 };
        long[] r = new long[] { 10, 10, 1, 1, 1, 1 };
        // when
        // then
        assertThat(Operarray.operArray(Operarray::gcdi, a, a[0])).isEqualTo(r);
    }
}