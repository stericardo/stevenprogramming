package com.stevenprogramming.library.core.ignore.interfaces.impl;

import com.stevenprogramming.library.core.ignore.interfaces.BaseInterface;

/**
 * @Autor Steven Ricardo Mendez Brenes
 * @date 2018-Apr-09 2:39:02 PM
 * @Version 1.0
 */
public class BaseInterfaceImpl implements BaseInterface {

	private InternalInterface internalInterface;
	
	public BaseInterfaceImpl() {

	}

	public BaseInterfaceImpl(InternalInterface internalInterface) {
		this.internalInterface = internalInterface;
	}

}
