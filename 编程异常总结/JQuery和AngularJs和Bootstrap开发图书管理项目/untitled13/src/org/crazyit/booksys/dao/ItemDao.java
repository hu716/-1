package org.crazyit.booksys.dao;

import java.util.List;

import org.crazyit.booksys.domain.Item;
import org.crazyit.common.dao.BaseDao;

public interface ItemDao extends BaseDao<Item>
{
	/**
	 * 根据入库单ID查找该入库单包含的所有入库项
	 * @param inventoryId 入库单ID
	 * @return 指定入库单对应的全部入库项
	 */
	List<Item> findByInventoryId(Integer inventoryId);
}
