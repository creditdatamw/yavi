/*
 * Copyright (C) 2018-2021 Toshiaki Maki <makingx@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package am.ik.yavi.arguments;

import am.ik.yavi.fn.Function3;

/**
 * Generated by https://github.com/making/yavi/blob/develop/scripts/generate-args.sh
 *
 * @since 0.3.0
 */
public class Arguments3<A1, A2, A3> extends Arguments2<A1, A2> {

	protected final A3 arg3;

	Arguments3(A1 arg1, A2 arg2, A3 arg3) {
		super(arg1, arg2);
		this.arg3 = arg3;
	}

	public final A3 arg3() {
		return this.arg3;
	}

	public final <X> X map(Function3<A1, A2, A3, X> mapper) {
		return mapper.apply(arg1, arg2, arg3);
	}
}
