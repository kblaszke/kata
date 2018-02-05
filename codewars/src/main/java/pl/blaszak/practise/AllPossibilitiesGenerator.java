package pl.blaszak.practise;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllPossibilitiesGenerator {

    public static List<Map<String, Boolean>> generate(LinkedList<String> inputs) {
        if (CollectionUtils.isEmpty(inputs)) {
            return Collections.singletonList(new HashMap<String, Boolean>());
        }
        String head = inputs.pollFirst();
        List<Map<String, Boolean>> tail = generate(inputs);
        return tail.stream()
                .flatMap(m -> Stream.of(new HashMap<String, Boolean>(m){{put(head, false);}}, new HashMap<String, Boolean>(m){{put(head, true);}}))
                .collect(Collectors.toList());
    }
}
