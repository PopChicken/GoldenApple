
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class MelonStem extends Flowable{
	public function __construct($meta = 0){
		parent::__construct(self::MELON_STEM, $meta, "Melon Stem");
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

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->isTransparent === true){ //TODO: Replace with common break method
				$this->getLevel()->dropItem($this, Item::get(Item::MELON_SEEDS, 0, mt_rand(0, 2)));
				$this->getLevel()->setBlock($this, new Air(), false, false, true);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}elseif($type === Level::BLOCK_UPDATE_RANDOM){
			if(mt_rand(0, 2) == 1){
				if($this->meta < 0x07){
					++$this->meta;
					$this->getLevel()->setBlock($this, $this, true);

					return Level::BLOCK_UPDATE_RANDOM;
				}else{
					for($side = 2; $side <= 5; ++$side){
						$b = $this->getSide($side);
						if($b->getID() === self::MELON_BLOCK){
							return Level::BLOCK_UPDATE_RANDOM;
						}
					}
					$side = $this->getSide(mt_rand(2, 5));
					$d = $side->getSide(0);
					if($side->getID() === self::AIR and ($d->getID() === self::FARMLAND or $d->getID() === self::GRASS or $d->getID() === self::DIRT)){
						$this->getLevel()->setBlock($side, new Melon(), true);
					}
				}
			}

			return Level::BLOCK_UPDATE_RANDOM;
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

	public function getDrops(Item $item){
		return [
			[Item::MELON_SEEDS, 0, mt_rand(0, 2)],
		];
	}
}