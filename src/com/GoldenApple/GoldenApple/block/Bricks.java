
use pocketmine\item\Item;

class Bricks extends Solid{
	public function __construct(){
		parent::__construct(self::BRICKS_BLOCK, 0, "Bricks");
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
				[Item::BRICKS_BLOCK, 0, 1],
			];
		}else{
			return [];
		}
	}
}