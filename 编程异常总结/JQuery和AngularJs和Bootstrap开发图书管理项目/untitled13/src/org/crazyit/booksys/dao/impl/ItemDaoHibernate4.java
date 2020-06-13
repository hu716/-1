package org.crazyit.booksys.dao.impl;

import java.util.List;

import org.crazyit.booksys.dao.ItemDao;
import org.crazyit.booksys.domain.Item;
import org.crazyit.common.dao.impl.BaseDaoHibernate4;

public class ItemDaoHibernate4 extends BaseDaoHibernate4<Item>
	implements ItemDao
{
	@Override
	public List<Item> findByInventoryId(Integer inventoryId)
	{
		return find("select it from Item as it where it.inventory.id = ?0"
			, new Object[]{inventoryId});
	}

}
