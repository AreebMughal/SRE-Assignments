
public void UpdateQuality()
{
	for (var i = 0; i < Items.Count; i++)
	{
		if (Items[i].Name != "Aged Brie" && Items[i].Name != "Backstage passes to a TAFKAL80ETC concert")
		{
			Items[i].decrementQuality();
		}
		else
		{
			if (Items[i].Quality < 50)
			{
				Items[i].incrementQuality();

				if (Items[i].Name == "Backstage passes to a TAFKAL80ETC concert")
				{
					if (Items[i].SellIn < 11)
						Items[i].incrementQuality();
				}
			}
		}
		Items[i].UpdateQualityBySellIn();
		
	}
}         


// All the methods that are written bellow would be in "Item Class" 


public static void incrementQuality() {
	if (this.Quality < 50) {
		this.Quality = this.Quality + 1;
	}
}


public static void decrementQuality() {
	if (this.Quality > 0 && this.Name != "Sulfuras, Hand of Ragnaros") {
		this.Quality = this.Quality - 1;
	}
}

public static void checkNdecrementSellIn() {
	if (this.Name != "Sulfuras, Hand of Ragnaros") {
		this.SellIn = this.SellIn - 1;
	}
	return this.SellIn;
}

public static void UpdateQualityBySellIn() {
	if (this.checkNdecrementSellIn() < 0)
	{
		if (this.Name != "Aged Brie")
		{
			if (this.Name != "Backstage passes to a TAFKAL80ETC concert")
			{
				this.decrementQuality();
			}
			else
			{
				this.Quality = this.Quality - this.Quality;
			}
		}
		else
		{
			this.incrementQuality();
		}
	}
}