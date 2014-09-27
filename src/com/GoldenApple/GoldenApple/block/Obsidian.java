
use pocketmine\item\Item;

class Obsidian extends Solid{
	public function __construct(){
		parent::__construct(self::OBSIDIAN, 0, "Obsidian");
		$this->hardness = 6000;
	}

	public function getBreakTime(Item $item){

		if($item->isPickaxe() >= 5){
			return 9.4;
		}else{
			return 250;
		}
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 5){
			return [
				[Item::OBSIDIAN, 0, 1],
			];
		}else{
			return [];
		}
	}
}