
use pocketmine\item\Item;

class HardenedClay extends Solid{
	public function __construct(){
		parent::__construct(self::HARDENED_CLAY, 0, "Hardened Clay");
		$this->hardness = 30;
	}

	public function getBreakTime(Item $item){
		switch($item->isPickaxe()){
			case 5:
				return 0.25;
			case 4:
				return 0.35;
			case 3:
				return 0.5;
			case 2:
				return 0.2;
			case 1:
				return 0.95;
			default:
				return 6.25;
		}
	}

}