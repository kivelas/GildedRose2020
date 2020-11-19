package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	@Test //covers loop test with one pass through the loop
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	@Test
	public void testMain() {
		
		//launch main
		String[] args = new String[0];
		GildedRose.main(args);
		
	}
	
	@Test
	public void testConsertPassQuality() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by two (perhaps should be one)
		assertEquals("Quality consert backstage passes", 22, quality);
	}
	
	@Test
	public void testConsertPassQualityWithSellInUnder6() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by three (perhaps should be one)
		assertEquals("Quality with sellIn under 6 consert backstage passes", 23, quality);
	}
	
	@Test
	public void testQualityWithSellInUnder0() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", -1, 6));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by two
		assertEquals("Quality with sellIn under 0 Conjured Mana Cake", 4, quality);
	}
	
	@Test
	public void testQualityWithSellInUnder0Concert() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 100));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased to 0
		assertEquals("Quality with sellIn under 0 concert passes", 0, quality);
	}
	
	@Test
	public void testQualityWithSellInUnder0QualityUnder50Brie() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", -1, 40));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by 2
		assertEquals("Quality with sellIn under 0 brie", 42, quality);
	}
	
	@Test
	public void testQualityUnder0() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 1, -1));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality remains the same
		assertEquals("Quality with quality under 0 Conjured Mana Cake", -1, quality);
	}
	
	@Test
	public void testQualityOf50() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by one
		assertEquals("Quality with quality under 0 Concert passes", 50, quality);
	}
	
	@Test
	public void testQuality0SellInUnder0() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -11, 0));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality remains the same
		assertEquals("Quality with quality 0 Sulfuras", 0, quality);
	}
	
	@Test
	public void testQuality1SellInUnder0() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -11, 1));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality remains the same
		assertEquals("Quality with quality 0 Sulfuras", 1, quality);
	}
	
	@Test
	public void testQualityOver50SellInUnder0() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", -11, 51));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality remains the same
		assertEquals("Quality with quality 0 Brie", 51, quality);
	}
	
	@Test //loop test 0 passes
	public void testLoop0pass() {
		//create an inn, add 0 item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.oneDay();
		
		//access a list of items, get the quality
		List<Item> items = inn.getItems();
		int quality = -100;
		if(! items.isEmpty()) { //check if items is empty, if not get the first item's quality
			items.get(0).getQuality();
		}
		//assert quality is -100
		assertEquals("Quality -100 with 0 loop passes", -100, quality);
	}
	
	// loop test 1 pass see e.g. exampleTest()
	
	@Test //loop test 2 passes
	public void testLoop2pass() {
		//create an inn, add two items, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		inn.oneDay();
		
		//access a list of items, get the quality of the second set
		List<Item> items = inn.getItems();
		int quality = items.get(1).getQuality();
		
		//assert quality remains the same
		assertEquals("Failed quality for Sulfuras", 80, quality);
	}
	
}
