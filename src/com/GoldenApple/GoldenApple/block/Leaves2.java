
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class Leaves2 extends Leaves{

	public function __construct($meta = 0){
		Transparent::__construct(self::LEAVES, $meta, "Leaves");
		$names = [
			self::ACACIA => "Acacia Leaves",
			self::DARK_OAK => "Dark Oak Leaves",
		];
		$this->name = $names[$this->meta & 0x03];
		$this->hardness = 1;
	}

	private function findLog(Block $pos, array $visited, $distance, &$check, $fromSide = null){
		++$check;
		$index = $pos->x . "." . $pos->y . "." . $pos->z;
		if(isset($visited[$index])){
			return false;
		}
		if($pos->getID() === self::WOOD2){
			return true;
		}elseif($pos->getID() === self::LEAVES2 and $distance < 3){
			$visited[$index] = true;
			$down = $pos->getSide(0)->getID();
			if($down === Item::WOOD2){
				return true;
			}
			if($fromSide === null){
				for($side = 2; $side <= 5; ++$side){
					if($this->findLog($pos->getSide($side), $visited, $distance + 1, $check, $side) === true){
						return true;
					}
				}
			}else{ //No more loops
				switch($fromSide){
					case 2:
						if($this->findLog($pos->getSide(2), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}elseif($this->findLog($pos->getSide(4), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}elseif($this->findLog($pos->getSide(5), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}
						break;
					case 3:
						if($this->findLog($pos->getSide(3), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}elseif($this->findLog($pos->getSide(4), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}elseif($this->findLog($pos->getSide(5), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}
						break;
					case 4:
						if($this->findLog($pos->getSide(2), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}elseif($this->findLog($pos->getSide(3), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}elseif($this->findLog($pos->getSide(4), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}
						break;
					case 5:
						if($this->findLog($pos->getSide(2), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}elseif($this->findLog($pos->getSide(3), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}elseif($this->findLog($pos->getSide(5), $visited, $distance + 1, $check, $fromSide) === true){
							return true;
						}
						break;
				}
			}
		}

		return false;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if(($this->meta & 0b00001100) === 0){
				$this->meta |= 0x08;
				$this->getLevel()->setBlock($this, $this, false, false, true);
			}
		}elseif($type === Level::BLOCK_UPDATE_RANDOM){
			if(($this->meta & 0b00001100) === 0x08){
				$this->meta &= 0x03;
				$visited = [];
				$check = 0;
				if($this->findLog($this, $visited, 0, $check) === true){
					$this->getLevel()->setBlock($this, $this, false, false, true);
				}else{
					$this->getLevel()->setBlock($this, new Air(), false, false, true);
					if(mt_rand(1, 20) === 1){ //Saplings
						$this->getLevel()->dropItem($this, Item::get($this->id, $this->meta & 0x03, 1));
					}

					return Level::BLOCK_UPDATE_NORMAL;
				}
			}
		}

		return false;
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$this->meta |= 0x04;
		$this->getLevel()->setBlock($this, $this, true);
	}

	public function getDrops(Item $item){
		$drops = [];
		if($item->isShears()){
			$drops[] = [Item::LEAVES2, $this->meta & 0x03, 1];
		}else{
			if(mt_rand(1, 20) === 1){ //Saplings
				$drops[] = [Item::SAPLING, $this->meta & 0x03, 1];
			}
		}

		return $drops;
	}
}