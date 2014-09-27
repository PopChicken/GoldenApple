
use pocketmine\item\Item;
use pocketmine\level\Level;

class GlowingRedstoneOre extends Solid{
	public function __construct(){
		parent::__construct(self::GLOWING_REDSTONE_ORE, 0, "Glowing Redstone Ore");
		$this->hardness = 15;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_SCHEDULED or $type === Level::BLOCK_UPDATE_RANDOM){
			$this->getLevel()->setBlock($this, Block::get(Item::REDSTONE_ORE, $this->meta), false, false, true);

			return Level::BLOCK_UPDATE_WEAK;
		}

		return false;
	}


	public function getBreakTime(Item $item){
		switch($item->isPickaxe()){
			case 5:
				return 0.6;
			case 4:
				return 0.75;
			default:
				return 15;
		}
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 4){
			return [
				[Item::REDSTONE_DUST, 0, mt_rand(4, 5)],
			];
		}else{
			return [];
		}
	}

}