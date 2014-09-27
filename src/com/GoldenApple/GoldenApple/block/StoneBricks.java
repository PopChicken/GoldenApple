
use pocketmine\item\Item;

class StoneBricks extends Solid{
	public function __construct($meta = 0){
		parent::__construct(self::STONE_BRICKS, $meta, "Stone Bricks");
		$names = [
			0 => "Stone Bricks",
			1 => "Mossy Stone Bricks",
			2 => "Cracked Stone Bricks",
			3 => "Chiseled Stone Bricks",
		];
		$this->name = $names[$this->meta & 0x03];
		$this->hardness = 30;
	}

	public function getBreakTime(Item $item){

		switch($item->isPickaxe()){
			case 5:
				return 0.4;
			case 4:
				return 0.5;
			case 3:
				return 0.75;
			case 2:
				return 0.25;
			case 1:
				return 1.5;
			default:
				return 7.5;
		}
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 1){
			return [
				[Item::STONE_BRICKS, $this->meta & 0x03, 1],
			];
		}else{
			return [];
		}
	}

}