
use pocketmine\item\Item;
use pocketmine\level\Level;

class RedstoneOre extends Solid{
	public function __construct(){
		parent::__construct(self::REDSTONE_ORE, 0, "Redstone Ore");
		$this->hardness = 15;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL or $type === Level::BLOCK_UPDATE_TOUCH){
			$this->getLevel()->setBlock($this, Block::get(Item::GLOWING_REDSTONE_ORE, $this->meta), false, false, true);

			return Level::BLOCK_UPDATE_WEAK;
		}

		return false;
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 2){
			return [
				[Item::REDSTONE_DUST, 0, mt_rand(4, 5)],
			];
		}else{
			return [];
		}
	}
}