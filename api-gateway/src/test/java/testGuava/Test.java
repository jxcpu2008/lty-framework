package testGuava;

//import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.google.common.base.Preconditions;

//import com.google.common.base.Preconditions;

public class Test {
	public static void main(String[] args) {
		new Test().doSomething(null);
	}

	public void doSomething(List<Object> list) {

		// checkArgument(list != null,
		// "List must not be null");
		// Preconditions.checkArgument(!list.isEmpty(),
		// "List must not be empty");
		System.out.println(CollectionUtils.isEmpty(list));
		System.out.println(CollectionUtils.isNotEmpty(list));

		System.out.println(list.isEmpty());
		List<Object> checkNotNull = Preconditions.checkNotNull(list);
		System.out.println(checkNotNull);

	}

}
