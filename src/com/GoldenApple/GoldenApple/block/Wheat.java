
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class Wheat extends Flowable{
	public function __construct($meta = 0){
		parent::__construct(self::WHEAT_BLOCK, $meta, "Wheat Block");
		$this->isActivable = true;
		$this->hardness = 0;
	}

	public function getBoundingBox(){
		return null;
	}


	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$down = $this->getSide(0);
		if($down->getID() === self::FARMLAND){
			$this->getLevel()->setBlock($block, $this, true, true);

			return true;
		}

		return false;
	}

	public function onActivate(Item $item, Player $player = null){
		if($item->getID() === Item::DYE and $item->getDamage() === 0x0F){ //Bonemeal
			$this->meta = 0x07;
			$this->getLevel()->setBlock($this, $this, true);
			if(($player->gamemode & 0x01) === 0){
				$item->count--;
			}

			return true;
		}

		return false;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->isTransparent === true){ //Replace with common break method
				//TODO
				//Server::getInstance()->api->entity->drop($this, Item::get(WHEAT_SEEDS, 0, 1));
				$this->getLevel()->setBlock($this, new Air(), false, false, true);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}elseif($type === Level::BLOCK_UPDATE_RANDOM){
			if(mt_rand(0, 2) == 1){
				if($this->meta < 0x07){
					++$this->meta;
					$this->getLevel()->setBlock($this, $this, true);
				}
			}
		}

		return false;
	}

	public function getDrops(Item $item){
		$drops = [];
		if($this->meta >= 0x07){
			$drops[] = [Item::WHEAT, 0, 1];
			$drops[] = [Item::WHEAT_SEEDS, 0, mt_rand(0, 3)];
		}else{
			$drops[] = [Item::WHEAT_SEEDS, 0, 1];
		}

		return $drops;
	}
}