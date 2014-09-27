

class NetherReactor extends Solid{
	public function __construct($meta = 0){
		parent::__construct(self::NETHER_REACTOR, $meta, "Nether Reactor");
		$this->isActivable = true;
	}

}