
use pocketmine\item\Item;

class MossStone extends Solid{
	public function __construct($meta = 0){
		parent::__construct(self::MOSS_STONE, $meta, "Moss Stone");
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
				return 10;
		}
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 1){
			return [
				[Item::MOSS_STONE, $this->meta, 1],
			];
		}else{
			return [];
		}
	}
}