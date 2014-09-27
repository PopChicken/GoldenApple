
use pocketmine\item\Item;

class Quartz extends Solid{
	public function __construct($meta = 0){
		parent::__construct(self::QUARTZ_BLOCK, $meta, "Quartz Block");
		$names = [
			0 => "Quartz Block",
			1 => "Chiseled Quartz Block",
			2 => "Quartz Pillar",
			3 => "Quartz Pillar",
		];
		$this->name = $names[$this->meta & 0x03];
	}

	public function getBreakTime(Item $item){

		switch($item->isPickaxe()){
			case 5:
				return 0.15;
			case 4:
				return 0.2;
			case 3:
				return 0.3;
			case 2:
				return 0.1;
			case 1:
				return 0.6;
			default:
				return 4;
		}
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 1){
			return [
				[Item::QUARTZ_BLOCK, $this->meta & 0x03, 1],
			];
		}else{
			return [];
		}
	}
}